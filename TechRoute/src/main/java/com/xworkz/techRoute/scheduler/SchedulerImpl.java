package com.xworkz.techRoute.scheduler;

import com.xworkz.techRoute.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerImpl implements Scheduler{

    @Autowired
    ProfileRepository profileRepository;

    @Override
    @Scheduled(fixedRate = 600000)
    public void clearOtp() {
        if (profileRepository.clearOtp()){
            System.err.println("otp cleared");
        }else {
            System.err.println("something went wrong while clearing otp");
        }
    }
}
