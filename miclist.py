import speech_recognition as sr
import time
from tkinter import *

class ML(Frame):
    def __init__(self, master, returnn):
        super().__init__(master)
        self.returnn = returnn

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        self.mic_index = StringVar()
        self.mic_index.set(None)

        # empty label for spacing
        Label(self, text = "").grid(row = 1, column = 3)

        # create mic radio buttons
        row = 2
        for mic in sr.Microphone.list_microphone_names():
            # create radio button and name
            Radiobutton(self, text = mic, variable = self.mic_index, value = row-2).grid(row = row, column = 1, sticky = W)

            row += 1

        # create mic selected button
        Button(self, text = "input selected", fg = "white", bg = "grey", command = self.selected_clicked).grid(row = row, column = 4, columnspan = 2, sticky = E)

    def selected_clicked(self):
        self.returnn(self.mic_index.get())