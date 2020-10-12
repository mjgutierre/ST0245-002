import numpy as np
import pandas as pd

data = pd.read_csv('0_train_balanced_15000.csv', sep= ';', header=0)


#considered features
decision = data.iloc[:,[2, 4, 5, 6, 7, 8, 9, 10, 13, 19, 22, 23, 24, 25, 32, 35,  36, 42, 45, 48, 50, 52, 52, 53, 54, 55, 56, 57, 58, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 77]] 

    decision = decision.fillna(0) 
    features = tuple(decision.columns.values)

    count=0
        for count in range (len(features)):
             if(decision.iloc[:,count].dtype == 'float64'):
                 decision.iloc[:,count] = decision.iloc[:,count].astype('float32')
            if(decision.iloc[:,count].dtype == 'int64'):
                decision.iloc[:,count] = decision.iloc[:,count].astype('int32') 
        
    print(decision.info())


