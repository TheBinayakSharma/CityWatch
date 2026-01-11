/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Civilian;
import Model.Organization;
import Model.Task;
import Model.Notice;
import java.util.ArrayList;

/**
 * Controller class for sorting and searching Civilians, Organizations, Tasks,
 * and Notices
 */
public class SortAndSearchController {

    /**
     * Sorts a list of Civilians by civId in ascending order
     *
     * @param list the list of Civilians
     */
    public static void selectionSortCivilianIdAsc(ArrayList<Civilian> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getCivId().compareTo(list.get(minIdx).getCivId()) < 0) {
                    minIdx = j;
                }
            }
            Civilian temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
        }
    }

    /**
     * Sorts a list of Civilians by civId in descending order
     *
     * @param list the list of Civilians
     */
    public static void selectionSortCivilianIdDesc(ArrayList<Civilian> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getCivId().compareTo(list.get(maxIdx).getCivId()) > 0) {
                    maxIdx = j;
                }
            }
            Civilian temp = list.get(i);
            list.set(i, list.get(maxIdx));
            list.set(maxIdx, temp);
        }
    }

    /**
     * Sorts a list of Civilians by name in ascending order
     *
     * @param list the list of Civilians
     */
    public static void insertionSortCivilianNameAsc(ArrayList<Civilian> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Civilian key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Sorts a list of Civilians by name in ascending order
     *
     * @param list the list of Civilians
     */
    public static void insertionSortCivilianNameDesc(ArrayList<Civilian> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Civilian key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Sorts a list of Organizations by orgId in ascending order
     *
     * @param list the list of Organizations
     */
    public static void insertionSortOrgIdAsc(ArrayList<Organization> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Organization key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getOrgId().compareTo(key.getOrgId()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Sorts a list of Organizations by orgId in descending order
     *
     * @param list the list of Organizations
     */
    public static void insertionSortOrgIdDesc(ArrayList<Organization> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Organization key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getOrgId().compareTo(key.getOrgId()) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Sorts a list of Organizations by name in ascending order using merge sort
     *
     * @param list the list of Organizations
     */
    public static void mergeSortOrgNameAsc(ArrayList<Organization> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Organization> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Organization> right = new ArrayList<>(list.subList(mid, list.size()));
        mergeSortOrgNameAsc(left);
        mergeSortOrgNameAsc(right);
        mergeOrgNameAsc(left, right, list);
    }

    /**
     * Merges two sorted sublists (left and right) into the original list in
     * ascending order by organization name
     *
     * @param left the left sublist, already sorted
     * @param right the right sublist, already sorted
     * @param list the original list to store the merged result
     */
    private static void mergeOrgNameAsc(ArrayList<Organization> left, ArrayList<Organization> right, ArrayList<Organization> list) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    /**
     * Sorts a list of Organizations by name in descending order using merge
     * sort
     *
     * @param list the list of Organizations
     */
    public static void mergeSortOrgNameDesc(ArrayList<Organization> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Organization> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Organization> right = new ArrayList<>(list.subList(mid, list.size()));
        mergeSortOrgNameDesc(left);
        mergeSortOrgNameDesc(right);
        mergeOrgNameDesc(left, right, list);
    }

    /**
     * Merges two sorted sublists (left and right) into the original list in
     * descending order by organization name
     *
     * @param left the left sublist, already sorted
     * @param right the right sublist, already sorted
     * @param list the original list to store the merged result
     */
    private static void mergeOrgNameDesc(ArrayList<Organization> left, ArrayList<Organization> right, ArrayList<Organization> list) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareToIgnoreCase(right.get(j).getName()) >= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    /**
     * Sorts a list of Tasks by issue date in ascending order using merge sort
     *
     * @param list the list of Tasks
     */
    public static void mergeSortTaskIssueDateAsc(ArrayList<Task> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Task> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Task> right = new ArrayList<>(list.subList(mid, list.size()));
        mergeSortTaskIssueDateAsc(left);
        mergeSortTaskIssueDateAsc(right);
        mergeTaskIssueDateAsc(left, right, list);
    }

    private static void mergeTaskIssueDateAsc(ArrayList<Task> left, ArrayList<Task> right, ArrayList<Task> list) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIssueDate().compareTo(right.get(j).getIssueDate()) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    /**
     * Sorts a list of Tasks by issue date in descending order using merge sort
     *
     * @param list the list of Tasks
     */
    public static void mergeSortTaskIssueDateDesc(ArrayList<Task> list) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;
        ArrayList<Task> left = new ArrayList<>(list.subList(0, mid));
        ArrayList<Task> right = new ArrayList<>(list.subList(mid, list.size()));
        mergeSortTaskIssueDateDesc(left);
        mergeSortTaskIssueDateDesc(right);
        mergeTaskIssueDateDesc(left, right, list);
    }

    private static void mergeTaskIssueDateDesc(ArrayList<Task> left, ArrayList<Task> right, ArrayList<Task> merged) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIssueDate().compareTo(right.get(j).getIssueDate()) >= 0) {
                merged.set(k++, left.get(i++));
            } else {
                merged.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            merged.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            merged.set(k++, right.get(j++));
        }
    }

    /**
     * Sorts a list of Tasks by title in ascending order
     *
     * @param list the list of Tasks
     */
    public static void selectionSortTaskTitleAsc(ArrayList<Task> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getTitle().compareToIgnoreCase(list.get(minIdx).getTitle()) < 0) {
                    minIdx = j;
                }
            }
            Task temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
        }
    }

    /**
     * Sorts a list of Tasks by title in descending order
     *
     * @param list the list of Tasks
     */
    public static void selectionSortTaskTitleDesc(ArrayList<Task> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getTitle().compareToIgnoreCase(list.get(maxIdx).getTitle()) > 0) {
                    maxIdx = j;
                }
            }
            Task temp = list.get(i);
            list.set(i, list.get(maxIdx));
            list.set(maxIdx, temp);
        }
    }

    /**
     * Sorts a list of Notices by issue date in ascending order
     *
     * @param list the list of Notices
     */
    public static void selectionSortNoticeIssueDateAsc(ArrayList<Notice> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getIssueDate().compareTo(list.get(minIdx).getIssueDate()) < 0) {
                    minIdx = j;
                }
            }
            Notice temp = list.get(i);
            list.set(i, list.get(minIdx));
            list.set(minIdx, temp);
        }
    }

    /**
     * Sorts a list of Notices by issue date in descending order
     *
     * @param list the list of Notices
     */
    public static void selectionSortNoticeIssueDateDesc(ArrayList<Notice> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (list.get(j).getIssueDate().compareTo(list.get(maxIdx).getIssueDate()) > 0) {
                    maxIdx = j;
                }
            }
            Notice temp = list.get(i);
            list.set(i, list.get(maxIdx));
            list.set(maxIdx, temp);
        }
    }

    /**
     * Sorts a list of Notices by title in ascending order
     *
     * @param list the list of Notices
     */
    public static void insertionSortNoticeTitleAsc(ArrayList<Notice> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Notice key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getTitle().compareToIgnoreCase(key.getTitle()) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Sorts a list of Notices by title in descending order
     *
     * @param list the list of Notices
     */
    public static void insertionSortNoticeTitleDesc(ArrayList<Notice> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Notice key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).getTitle().compareToIgnoreCase(key.getTitle()) < 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    /**
     * Searches Civilians by ID or name
     *
     * @param list the list of Civilians
     * @param query the search string
     * @return list of matching Civilians
     */
    public static ArrayList<Civilian> searchCivilian(ArrayList<Civilian> list, String query) {
        ArrayList<Civilian> results = new ArrayList<>();
        for (Civilian c : list) {
            if (c.getCivId().equalsIgnoreCase(query) || c.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(c);
            }
        }
        return results;
    }

    /**
     * Searches Organizations by ID or name
     *
     * @param list the list of Organizations
     * @param query the search string
     * @return list of matching Organizations
     */
    public static ArrayList<Organization> searchOrganization(ArrayList<Organization> list, String query) {
        ArrayList<Organization> results = new ArrayList<>();
        for (Organization o : list) {
            if (o.getOrgId().equalsIgnoreCase(query) || o.getName().toLowerCase().contains(query.toLowerCase())) {
                results.add(o);
            }
        }
        return results;
    }

    /**
     * Searches Tasks by ID or title
     *
     * @param list the list of Tasks
     * @param query the search string
     * @return list of matching Tasks
     */
    public static ArrayList<Task> searchTask(ArrayList<Task> list, String query) {
        ArrayList<Task> results = new ArrayList<>();
        for (Task t : list) {
            if (t.getTaskId().equalsIgnoreCase(query) || t.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(t);
            }
        }
        return results;
    }

    /**
     * Searches Notices by ID or title
     *
     * @param list the list of Notices
     * @param query the search string
     * @return list of matching Notices
     */
    public static ArrayList<Notice> searchNotice(ArrayList<Notice> list, String query) {
        ArrayList<Notice> results = new ArrayList<>();
        for (Notice n : list) {
            if (n.getNoticeId().equalsIgnoreCase(query) || n.getTitle().toLowerCase().contains(query.toLowerCase())) {
                results.add(n);
            }
        }
        return results;
    }
}
