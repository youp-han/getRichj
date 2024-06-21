package com.jjst.getRich.module.GenNumbers.service;

import com.jjst.getRich.dto.ResultEntity;
import com.jjst.getRich.dto.ResultValueDto;
import com.jjst.getRich.module.DhNumbers.entity.ResultValue;
import com.jjst.getRich.service.ResultGeneratorService;
import com.jjst.getRich.service.ResultValueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultGeneratorServiceImpl implements ResultGeneratorService {

//todo temp codes

    //우선 각 번호의 출현 빈도를 분석해보겠습니다
//    import pandas as pd
//
//# Load the uploaded CSV file
//            file_path = '/mnt/data/win_history.csv'
//    lotto_data = pd.read_csv(file_path)
//
//            # Display the first few rows of the dataset to understand its structure
//lotto_data.head()


    //먼저 번호 조합의 출현 패턴을 살펴보겠습니다
//    import matplotlib.pyplot as plt
//
//# Flatten the main winning numbers into a single series
//    winning_numbers = pd.concat([lotto_data['drwtNo1'], lotto_data['drwtNo2'], lotto_data['drwtNo3'],
//    lotto_data['drwtNo4'], lotto_data['drwtNo5'], lotto_data['drwtNo6']])
//
//            # Calculate the frequency of each number
//    frequency = winning_numbers.value_counts().sort_index()
//
//# Plot the frequency of each number
//plt.figure(figsize=(15, 8))
//            plt.bar(frequency.index, frequency.values, color='skyblue')
//            plt.xlabel('Lotto Numbers')
//            plt.ylabel('Frequency')
//            plt.title('Frequency of Lotto Numbers')
//            plt.xticks(range(1, 46))
//            plt.grid(axis='y')
//            plt.show()

    //번호 간의 상관관계를 분석하여, 특정 번호가 함께 출현하는 경향이 있는지 확인

//    # Find the most common combinations of numbers
//# Convert each row of winning numbers into a sorted tuple
//    lotto_data['combination'] = lotto_data.apply(lambda row: tuple(sorted([row['drwtNo1'], row['drwtNo2'], row['drwtNo3'],
//                                                                   row['drwtNo4'], row['drwtNo5'], row['drwtNo6']])), axis=1)
//
//            # Calculate the frequency of each combination
//    combination_frequency = lotto_data['combination'].value_counts()
//
//# Display the top 10 most common combinations
//            top_combinations = combination_frequency.head(10)
//    top_combinations


}
