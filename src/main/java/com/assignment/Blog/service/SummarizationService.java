package com.assignment.Blog.service;

import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SummarizationService {

    public String summarizeText(String text){

        try(InputStream modelIn = getClass().getResourceAsStream("/en-sent.bin")){
            SentenceModel model = new SentenceModel(modelIn);
            SentenceDetectorME sentenceDetector = new SentenceDetectorME(model);

            String[] sentences = sentenceDetector.sentDetect(text);

            List<String> keywords = Arrays.asList("important","key","benifit","advantage","essential","vital","significant","notable", "impact");
            // DEBUG: Print the detected sentences

            List<String> importantSentences = Arrays.stream(sentences)
                    .filter(sentence->keywords.stream().anyMatch(sentence.toLowerCase()::contains)|| sentence.length()>100)
                    .limit(3)
                    .collect(Collectors.toList());

//            List<String> summary = Arrays.stream(sentences)
//                    .limit(3)
//                    .collect(Collectors.toList());

            return String.join("",importantSentences);
        }catch (Exception e){
            e.printStackTrace();
            return "Error in Summarization";
        }
    }
}
