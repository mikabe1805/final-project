from tkinter import *

class Choose(Frame):
    def __init__(self, master, returnn):
        super().__init__(master)
        self.returnn = returnn
        self.choice = None

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        # enter the name of the file you would like to create/edit
        Label(self, text = "Select your desired program!").grid(row = 0, column = 0, sticky = W)

        Label(self, text = "").grid(row = 1, column = 0)
        # create mic selected button
        Button(self, text = "Speech to text", fg = "white", bg = "grey", command = self.speechtotext).grid(row = 2, column = 0, columnspan = 2, sticky = W)

        Button(self, text = "Grades Calculator", fg = "white", bg = "grey", command = self.gradecalculator).grid(row = 3, column = 0, columnspan = 2, sticky = W)

        Button(self, text = "Pomodoro", fg = "white", bg = "grey", command = self.pomodoro).grid(row = 4, column = 0, columnspan = 2, sticky = W)

        Button(self, text = "Tutorial Helper", fg = "white", bg = "grey", command = self.tutorialhelper).grid(row = 5, column = 0, columnspan = 2, sticky = W)

        Button(self, text = "Games", fg = "white", bg = "grey", command = self.games).grid(row = 6, column = 0, columnspan = 2, sticky = W)

    def speechtotext(self):
        self.returnn("speechtotext")

    def games(self):
        self.returnn("games")

    def gradecalculator(self):
        self.returnn("gradecalculator")

    def pomodoro(self):
        self.returnn("pomodoro")

    def tutorialhelper(self):
        self.returnn("tutorialhelper")