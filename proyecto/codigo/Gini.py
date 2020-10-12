from sklearn.tree import DecisionTreeClasifier #(clasificador de arbol de decisiones)
from utilities.utils import read_dataset
from sklearn.model_selection import train_test_split
#(graphic tree)
from sklearn.tree import export_graphviz 
import graphviz
import matplotlib.pyplot as plt 
import numpy as np 


data=read_dataset()

X_train, X_test, y_train, y_test = train_test_split(extremely_balanced, target)

    tree=DecisionTreeClasifier()

    tree.fit(X_test,y_test)

    tree.score(X_train,y_train)


#check if the value is numeric
def numeric(valor):
    return isinstance(valor,int)or isinstance(valor,float)

    numeric(data[][])

#This class compares the index number with the defined labels
class evaluate:

    def __init__(self, column, value, headers):
        self.column = column
        self.value = value
        self.headers = headers

    def match(self, example):
        val = example[self.column]
        if is_numeric(val):
            return val >= self.value
        else:
            return val == self.value

    def __repr__(self):
        condition = "=="
        if is_numeric(self.value):
            condition = ">="
        return f"Is {self.headers[self.column]} {condition} {str(self.value)}"

evaluate()
#Save the value 
a=evaluate()
a


#Divide the possible successful answers
def split(headers,evaluate)
  successful_headers,wrong_headers= [], []
   for headersin headers:
       if evaluate.compares(headers):
         successful_headers.append(headers)
       else:
           wrong_headers.append(headers)
        return successful_headers,wrong_headers

successful_headers,wrong_headers=split(data,evaluate())

#Impurity
def __init__(self) :
    self.calculoPonderada=float(a1,a0,b1,b0)
 return ((b0+b1)*calculoImpureza(b0,b1)+(a0+a1)*calculoImpureza(a0,a1))/(b1+a0+a1+b0)


def __init__(self) :
 self.calculoImpureza=float(n0,n1)
    p0=n0/(n1+n0) #succesful students/total students
    p1=n1/(n1+n0) #failed students/total students
        return (1.0-(p0*p0+p1*p1)) 
    #(succesful students/total students)*(succesful students/total students)+(failed students/total students)*failed students/total students


