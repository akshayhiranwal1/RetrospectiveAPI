package com.SIS.RetrospectiveService;

import com.SIS.RetrospectiveService.model.Feedback;
import com.SIS.RetrospectiveService.model.Retrospective;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestData {
    public static List<Retrospective> retroList = Arrays.asList(
            new Retrospective(1,"Test","Summary","Part1,Part2", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback())),
            new Retrospective(2,"Test2","Summary2","Part3,Part4", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback())),
            new Retrospective(3,"Test3","Summary3","Part5,Part6", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback())),
            new Retrospective(4,"Test4","Summary4","Part7,Part8", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback())),
            new Retrospective(5,"Test5","Summary5","Part9,Part10", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback())),
            new Retrospective(6,"Test6","Summary6","Part11,Part12", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback()))
    );

    public static Retrospective insertRetroModel
            = new Retrospective(1,"Test","Summary","Part1,Part2", Date.valueOf(LocalDate.now()),Arrays.asList(new Feedback()));
}
