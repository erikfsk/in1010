import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelQuickSort<T extends Comparable<T>> {
    private T[] list;
    private final int numberOfThreads;
    private final int elementsPerThread;
    private final ExecutorService executor;
    private final Lock lock = new ReentrantLock();
    private final Condition allDone = lock.newCondition();
    private int numberOfSorters = 0;

    /**
     * Runnable representing the task of sorting the list
     * between a given range of indices. */
    class SortSection implements Runnable {
        private final int fromIndex, toIndex;

        public SortSection(int fromIndex, int toIndex) {
            this.fromIndex = fromIndex; this.toIndex = toIndex;
            lock.lock();
            try {
                numberOfSorters++;
            } finally {
                lock.unlock();
            }
        }

        public void run() {
            // Sort!
            quickSort(fromIndex, toIndex);

            lock.lock();
            try {
                if (--numberOfSorters == 0)
                    allDone.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * Initialize the sorter.
     * @param list the array to be sorted
     * @param numberOfThreads the size of the thread pool to use.
     */
    public ParallelQuickSort(T[] list, int numberOfThreads) {
        this.list = list;
        this.numberOfThreads = numberOfThreads;
        elementsPerThread = list.length / numberOfThreads;
        executor = Executors.newFixedThreadPool(numberOfThreads);
    }

    /**
     * Start a sorting job containing the whole array, then wait for
     * all jobs to finish.
     */
    public void sort() {
        executor.execute(new SortSection(0, list.length-1));
        lock.lock();
        try {
            while (numberOfSorters > 0)
                allDone.await();
            // Tell the executor to terminate. shutdown denies
            // any further jobs. Then wait for it to terminate (
            // should be instantly, wait maximum 1 second).
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("NB! Sorting did not finish.");
        } finally {
            lock.unlock();
        }
    }
    /**
     * Actuall Quick Sort.
     * @param low lower index to include in sorting (inclusive)
     * @param high upper index to include in sorting (inclusive).
     */
    private void quickSort(int low, int high) {
        if (high - low < 1) return;  // Array of length < 2 is sorted.

        int i = low, j = high;

        // Just choose the middle element as pivot (good if partially sorted).
        T pivot = list[low + (high-low)/2];

        // Put all elements smaller than pivot to the left of pivot.
        while (i <= j) {
            // Scan for an element larger than pivot.
            while (list[i].compareTo(pivot) < 0)
                i++;
            // Scan for an element smaller than pivot.
            while (list[j].compareTo(pivot) > 0)
                j--;

            // If we found something that needed to be swapped, do it!
            if (i <= j)
                swap(i++, j--);
        }

        // Spawn new threads only if the portion is large.
        // If portions are small, just do regular recursion (if non empty).
        if (j - low > elementsPerThread)
            executor.execute(new SortSection(low, j));
        else if ( j - low > 0)
            quickSort(low, j);
        if (high - i > elementsPerThread)
            executor.execute(new SortSection(i, high));
        else if (high - i > 0)
            quickSort(i, high);
    }

    private void swap(int a, int b) {
        T tmp = list[a];
        list[a] = list[b];
        list[b] = tmp;
    }
}

