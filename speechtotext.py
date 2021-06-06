# install pipwin
# install pyaudio
# install speechRecognition
#  https://cmusphinx.github.io/wiki/download/
import speech_recognition as sr
import time
from tkinter import *

class STT(Frame):
    def __init__(self, master):
        super().__init__(master)
        self.ambient = False
        self.main()

    def main(self):
        # create mic and recognizer
        rec = sr.Recognizer()
        mic = sr.Microphone()
        print("hi!")
        self.get_mic()
        an = input("would you like the program to leave out ambient noise? (will make detection more accurate but might pick up less) (Y/N) ")
        if an.lower() == "y":
            self.ambient = True 
        #time.sleep(3)
        speech = self.get_speech(rec, mic)
        while True:
            if speech["error"]:
                print("ERROR: {}".format(speech["error"]))
            elif speech["transcription"] != None:
                print(speech["transcription"])
                with open('speech.txt', 'a') as f:
                    f.write(str(speech["transcription"] + " "))
            speech = self.get_speech(rec, mic)

    def get_speech(self, recognizer, mic):
        # check for appropriate types
        if not isinstance(recognizer, sr.Recognizer):
            raise TypeError('`recognizer` must be `Recognizer` instance')

        if not isinstance(mic, sr.Microphone):
            raise TypeError('`microphone` must be a `Microphone` instance')

        #adjust microphone sensitivity and get sound from mic
        with mic as source:
            if self.ambient:
                recognizer.adjust_for_ambient_noise(source)
            audio = recognizer.listen(source)

        # response
        response = {
            "success": True,
            "error": None,
            "transcription": None
        }

        try:
            response["transcription"] = recognizer.recognize_google(audio)
        except sr.RequestError:
            # problems with API
            response["success"] = False
            response["error"] = "API unavailable"
        except sr.UnknownValueError:
            # speech was unintelligible
            response["error"] = "unable to recognize speech"

        return response

    def get_mic(self):
        answer = input("would you like to pick a mic?(Y/N) ")
        if answer.lower() == "y":
            listt = sr.Microphone.list_microphone_names()
            i = 0
            while i < len(listt):
                print("%d. %s" % (i, listt[i]))
                i += 1
            index = input("choose an index: ")
            mic = sr.Microphone(device_index=int(index))

