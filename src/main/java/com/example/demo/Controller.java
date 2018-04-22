package com.example.demo;

import com.example.demo.domain.Data;
import com.example.demo.domain.DataRelatedItem;
import com.example.demo.repository.DataRelatedItemRepository;
import com.example.demo.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private DataRepository dataRepository;
    @Autowired
    private DataRelatedItemRepository dataRelatedItemRepository;

    @Autowired
    public void add() throws IOException {
        JsonParser jsonParser = new JsonParser();
        ArrayList<ArrayList<String>> list = new ArrayList<>(jsonParser.parser());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 8) {
                Data data = new Data(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                                     list.get(i).get(4), list.get(i).get(5), list.get(i).get(6), list.get(i).get(7));
                dataRepository.save(data);
            } else {
                DataRelatedItem dataRelatedItem = new DataRelatedItem(list.get(i).get(0), list.get(i).get(1), list.get(i).get(2), list.get(i).get(3),
                                                                      list.get(i).get(4), list.get(i).get(5), list.get(i).get(6), list.get(i).get(7), list.get(i).get(8));
                dataRelatedItemRepository.save(dataRelatedItem);
            }
        }



//        Data data;


//        if (list.size() == 9) {
//            DataRelatedItem dataRelatedItem;
//            for (int i = 0; i < list.size(); i+=9) {
//                dataRelatedItem = new DataRelatedItem(list.get(i), list.get(i+1), list.get(i+2), list.get(i+3),
//                        list.get(i+4), list.get(i+5), list.get(i+6), list.get(i+7), list.get(i+8));
//                dataRepository.save(dataRelatedItem);
//            }
//        }
//        for (int i = 0; i < list.size(); i+=8) {
//            data = new Data(list.get(i), list.get(i+1), list.get(i+2), list.get(i+3),
//                            list.get(i+4), list.get(i+5), list.get(i+6), list.get(i+7));
//            dataRepository.save(data);
//        }
    }

}
