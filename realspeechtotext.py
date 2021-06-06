# install pipwin
# install pyaudio
# install speechRecognition
#  https://cmusphinx.github.io/wiki/download/
import speech_recognition as sr
import time
from tkinter import *

class STT(Frame):
    def __init__(self, master, callback_on_selected, mic_index):
        super().__init__(master)
        self.ambient = False
        self.callback_on_selected = callback_on_selected
        self.rec = sr.Recognizer()
        if mic_index == None:
            self.mic = sr.Microphone()
        else:
            self.mic = sr.Microphone(device_index=mic_index)

        self.grid()
        self.create_widgets()

    def create_widgets(self):
        # empty label for spacing
        Label(self, text = "").grid(row = 1, column = 3)

        # create mic and recognizer
        Button(self, text = "speech to text", fg = "white", bg = "grey", command = self.speech()).grid(row =2, column = 2, columnspan = 2, sticky = E)
        Label(self, text = "").grid(row = 3, column = 3)
        Button(self, text = "select mic", fg = "white", bg = "grey", command = self.get_mic()).grid(row =4, column = 1, columnspan = 2, sticky = E)
        Button(self, text = "toggle reduce ambient noise", fg = "white", bg = "grey", command = self.ambient_noise()).grid(row =4, column = 3, columnspan = 2, sticky = E)
        Label(self, text = "").grid(row = 5, column = 3)
        Label(self, text = "").grid(row = 6, column = 3)
        self.text = Label(self, text = "")
        self.text.grid(row = 7, column = 3)

    def speech(self):
        speech = self.get_speech()

        if speech["error"]:
            print("ERROR: {}".format(speech["error"]))
        elif speech["transcription"] != None:
            self.text = Label(self, text = speech["transcription"])
            self.text.grid(row = 7, column = 3)
            with open('speech.txt', 'a') as f:
                f.write(str(speech["transcription"] + " "))
            

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
