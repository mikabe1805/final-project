from tkinter import *

class Games(Frame):
    def __init__(self, master, returnn):
        super().__init__(master)
        self.returnn = returnn
        self.choice = None

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        # enter the name of the file you would like to create/edit
        Label(self, text = "Select the game you'd like to play!").grid(row = 0, column = 0, sticky = W)

        Label(self, text = "").grid(row = 1, column = 0)


        Button(self, text = "Sudoku", fg = "white", bg = "grey", command = self.sudoku).grid(row = 2, column = 0, columnspan = 2, sticky = W)

        Button(self, text = "Snake", fg = "white", bg = "grey", command = self.snake).grid(row = 3, column = 0, columnspan = 2, sticky = W)

    def snake(self):
        self.returnn("snake")

    def sudoku(self):
        self.returnn("sudoku")