# install pipwin
# install pyaudio
# install speechRecognition
#  https://cmusphinx.github.io/wiki/download/
import speech_recognition as sr
import time


def get_speech(recognizer, mic):
    # check for appropriate types
    if not isinstance(recognizer, sr.Recognizer):
        raise TypeError('`recognizer` must be `Recognizer` instance')

    if not isinstance(mic, sr.Microphone):
        raise TypeError('`microphone` must be a `Microphone` instance')

    #adjust microphone sensitivity and get sound from mic
    with mic as source:
        recognizer.adjust_for_ambient_noise(source)
        audio = recognizer.listen(source)

    # response
    response = {
        "success": True,
        "error": None,
        "transcription": None
    }

    try:
        response["transcription"] = recognizer.recognize_sphinx(audio)
    except sr.RequestError:
        # problems with API
        response["success"] = False
        response["error"] = "API unavailable"
    except sr.UnknownValueError:
        # speech was unintelligible
        response["error"] = "unable to recognize speech"

    return response

if __name__ == "__main__":
    # create mic and recognizer
    rec = sr.Recognizer()
    mic = sr.Microphone()
    print("hi!")
    #time.sleep(3)
    answer = input("would you like to pick a mic?(Y/N) ")
    if answer.lower() == "y":
        print(sr.Microphone.list_microphone_names())
        index = input("choose an index: ")
        mic = sr.Microphone(device_index=int(index))
    speech = get_speech(rec, mic)
    while True:
        if speech["transcription"] != None:
            if speech["error"]:
                print("ERROR: {}".format(speech["error"]))
            print(speech["transcription"])
            with open('speech.txt', 'a') as f:
                f.write(str(speech["transcription"] + " "))
        speech = get_speech(rec, mic)

