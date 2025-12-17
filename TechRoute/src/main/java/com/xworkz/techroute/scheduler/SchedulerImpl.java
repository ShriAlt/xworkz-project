package com.xworkz.techroute.scheduler;

import com.xworkz.techroute.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SchedulerImpl implements Scheduler{

    @Autowired
    ProfileRepository profileRepository;

    @Override
    @Scheduled(fixedRate = 600000)
    public void clearOtp() {
        if (profileRepository.clearOtp()){
            log.info("otp cleared");
        }else {
            log.info("something went wrong while clearing otp");
        }
    }
}
