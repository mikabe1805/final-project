from tkinter import *

class FL(Frame):
    def __init__(self, master, returnn):
        super().__init__(master)
        self.returnn = returnn

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        # enter the name of the file you would like to create/edit
        Label(self, text = "Enter the name of the file you would like to create/edit").grid(row = 0, column = 0, sticky = W)
        self.w = Entry()
        self.w.grid(row=1,column=0)
        # create mic selected button
        Button(self, text = "Ready", fg = "white", bg = "grey", command = self.selected_clicked).grid(row = 1, column = 1, columnspan = 2, sticky = E)

    def selected_clicked(self):
        ww = self.w.get()
        self.w.destroy()
        self.returnn(ww)