__author__ = 'lji'

import random
import os
import sys

class Calculator(object):
    __value__ = 0
    __valueHistory__ = []

    def add(self, number):
        self.__valueHistory__.append(self.__value__)
        self.__value__ += number

    def sub(self, number):
        self.__valueHistory__.append(self.__value__)
        self.__value__ -= number

    def div(self, number):
        self.__valueHistory__.append(self.__value__)
        self.__value__ /= number

    def multiply(self, number):
        self.__valueHistory__.append(self.__value__)
        self.__value__ *= number

    def clear(self):
        self.__valueHistory__.append(self.__value__)
        self.__value__ = 0

    def getValue(self):
        return self.__value__

    def printHistory(self):
        print(self.__valueHistory__)
        return


## Create an instance of the Calulator Class
calc = Calculator()

## add 5 to the calc
calc.add(5)
## add 2 to the calc
calc.add(2)

## 10x
calc.multiply(10)

## divide by 6
calc.div(6)

## fetch current value on calc
val = calc.getValue()
print(val)

calc.clear()

## display all previous values of calc - that is, its history
calc.printHistory()



