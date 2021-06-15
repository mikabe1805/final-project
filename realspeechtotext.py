# install pipwin
# install pyaudio
# install speechRecognition
#  https://cmusphinx.github.io/wiki/download/
import speech_recognition as sr
import time
from tkinter import *

class STT(Frame):
    def __init__(self, master, callback_on_selected, mic_index, file_name):
        super().__init__(master)
        self.ambient = False
        self.talk = False
        self.root=master
        self.callback_on_selected = callback_on_selected
        self.rec = sr.Recognizer()
        if mic_index == None:
            self.mic = sr.Microphone()
        else:
            self.mic = sr.Microphone(device_index=int(mic_index))
        self.file_name = file_name
        open(file_name + ".txt","w+")

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        # empty label for spacing
        Label(self, text = "").grid(row = 1, column = 3)

        # create mic and recognizer
        Button(self, text = "speech to text", fg = "white", bg = "grey", command = self.speech).grid(row =2, column = 2, columnspan = 2, sticky = E)
        Label(self, text = "").grid(row = 3, column = 3)
        Button(self, text = "select mic", fg = "white", bg = "grey", command = self.get_mic).grid(row =4, column = 1, columnspan = 2, sticky = E)
        Button(self, text = "toggle reduce ambient noise", fg = "white", bg = "grey", command = self.ambient_noise).grid(row =4, column = 3, columnspan = 2, sticky = E)
        Button(self, text = "toggle speech to text", fg = "white", bg = "grey", command = self.speechhhh).grid(row =5, column = 2, columnspan = 2, sticky = E)
        Label(self, text = "").grid(row = 6, column = 3)
        Label(self, text = "").grid(row = 7, column = 3)
        self.text = Label(self, text = "")
        self.text.grid(row = 7, column = 3, columnspan = 5, rowspan=5)

    def speech(self):
        speech = self.get_speech()

        if speech["error"]:
            print("ERROR: {}".format(speech["error"]))
        elif speech["transcription"] != None:
            text = speech["transcription"]
            self.text = Text(height=5, width=5, yscrollcommand=True, xscrollcommand=True)
            self.text.grid(row = 8, column = 3)
            i = 0
            speechh = text.split(" ")
            #speechh = []
            #while i < len(text):
                #speechh.append(str(text[i]))
            
            i = 0
            while i+1 < len(speechh):
                #if speechh[i] == "new" and speech[i+1] == "line":
                if speechh[i] + speechh[i+1] == "newline":
                    speechh[i] = "\n"
                    speechh.remove(speechh[i+1])
                elif speechh[i].lower() == "tab" or speechh[i].lower() == "tab":
                    speechh[i] = "\t"
                elif speechh[i].lower() == "period" or speechh[i].lower() == "dot":
                    speechh[i] = "."
                elif speechh[i].lower() == "comma":
                    speechh[i] = ","
                elif speechh[i].lower() == "stop":
                    self.talk = False
                elif speechh[i+1] != "comma" and speechh[i+1] != "period":
                    speechh[i] =  speechh[i]+" "
                i += 1
            i = 0
            with open(self.file_name + '.txt', 'a') as f:
                while i < len(speechh):
                    f.write(str(speechh[i]))
                    self.text.insert(INSERT, speech[i]) 
                    i +=1
        if self.talk:
            self.handling()
            #time.sleep(3)
            #self.text.destroy()
            

    def get_speech(self):
        # check for appropriate types
        if not isinstance(self.rec, sr.Recognizer):
            raise TypeError('`recognizer` must be `Recognizer` instance')

        if not isinstance(self.mic, sr.Microphone):
            raise TypeError('`microphone` must be a `Microphone` instance')

        #adjust microphone sensitivity and get sound from mic
        with self.mic as source:
            if self.ambient:
                self.rec.adjust_for_ambient_noise(source)
            audio = self.rec.listen(source)

        # response
        response = {
            "success": True,
            "error": None,
            "transcription": None
        }

        try:
            response["transcription"] = self.rec.recognize_google(audio)
        except sr.RequestError:
            # problems with API
            response["success"] = False
            response["error"] = "API unavailable"
        except sr.UnknownValueError:
            # speech was unintelligible
            response["error"] = "unable to recognize speech"

        return response

    def get_mic(self):
        self.callback_on_selected()

    def ambient_noise(self):
        if self.ambient == False:
            self.ambient = True
        else:
            self.ambient = False

    def speechhhh(self):
        if self.talk == False:
            self.talk = True
            self.handling()
        else:
            self.talk = False
        
        
    def handling(self):
        self.root.after(50, self.speech)
