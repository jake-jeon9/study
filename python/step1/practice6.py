import os


def search(dirname):
    try:
        fileNameList = os.listdir(dirname)
        for name in fileNameList:
            print(name)
            full_fileName = os.path.join(dirname, name)
            if os.path.isdir:
                search(full_fileName)
            else:
                extention = os.path.splitext(full_fileName)[-1]
                if extention == ".py":
                    print(full_fileName)
    except PermissionError:
        pass


search("C:\\")
