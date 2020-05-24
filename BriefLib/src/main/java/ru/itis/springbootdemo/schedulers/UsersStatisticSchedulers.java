package ru.itis.springbootdemo.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.UsersRepository;
import ru.itis.springbootdemo.service.StatisticService;

import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class UsersStatisticSchedulers {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private StatisticService statisticService;

    @Transactional
    @Scheduled(cron = "0 0 10 28 * ?")
    public void run() {
//        List<User> partners = usersRepository.findAllSubmittedByRoleAndCreator(Role.PARTNER, usersRepository.getOne(1L));
//        for (User partner : partners) {
//            statisticService.saveStatistic(partner);
//        }
        statisticService.sendReport();
    }
}
