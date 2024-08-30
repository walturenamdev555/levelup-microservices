package com.app.activity.repo;

import com.app.activity.domain.Transfer;
import com.app.activity.feign.TransferServiceFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferRepoImpl implements TransferRepo{
    private final TransferServiceFeign transferServiceFeign;

    @Override
    public Transfer getActivityById(String transferId) {
        return transferServiceFeign.getActivityById(transferId);
    }

    @Override
    public List<Transfer> getActivities() {
        return transferServiceFeign.getActivities();
    }

    @Override
    public List<Transfer> getActivitiesByAccountId(Long accountNumber) {
        return transferServiceFeign.getActivitiesByAccountId(accountNumber);
    }
}
