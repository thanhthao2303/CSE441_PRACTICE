package com.example.prac02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class StaffViewModel extends ViewModel {
    private final MutableLiveData<List<String>> staffList = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<String>> getStaffList() {
        return staffList;
    }

    public void addStaff(String staffInfo) {
        List<String> currentList = staffList.getValue();
        if (currentList != null) {
            currentList.add(staffInfo);
            staffList.setValue(currentList);
        }
    }
}
