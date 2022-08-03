import joblib
from os.path import dirname, join

def main( glu,bp,st,nop,insul,bmi,dpf,age):
    filename = join(dirname(__file__),'RFmodel.sav')
    loaded_model = joblib.load(open(filename, 'rb'))

    glucose = int(glu)
    bloodpress = int(bp)
    skinthick = int(st)
    nofp = int(nop)
    insulin = int(insul)
    bodymassi = float(bmi)
    dpfunction = float(dpf)
    agei = int(age)

    list = [[nofp, glucose, bloodpress, skinthick, insulin,bodymassi, dpfunction, agei]]
    if loaded_model.predict(list) == 0:
        return 'Person is likely to NOT have diabetes'
    else:
        return 'Person is likely to have diabetes'
