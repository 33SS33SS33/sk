package top50Google;

public class TimeNeededtoInformAllEmployees {
    /**
     * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
     * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
     * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
     * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
     * Return the number of minutes needed to inform all the employees about the urgent news.
     * Example 1:
     * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
     * Output: 0
     * Explanation: The head of the company is the only employee in the company.
     */

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; ++i)
            res = Math.max(res, dfs(i, manager, informTime));
        return res;
    }

    public int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] != -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}
