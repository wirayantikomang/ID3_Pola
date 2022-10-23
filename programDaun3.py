import pandas as pd

data = pd.read_csv("dataDaun.csv")

jumDat = data.shape[0]

hasil = []
prediksi = [] 
def klasifikasi(warna, bentuk, teksturTepi, Bau ):
    
    if warna == 0:
        if bentuk == 3: 
            hasil.append("Kantil") 
            print("Kantil") 
        elif bentuk == 4: 
            hasil.append("Kamboja") 
            print("Kamboja") 
        else  : 
            hasil.append("Tidak Diketahui") 
    elif warna == 1: 
        if teksturTepi == 1: 
            hasil.append("kembang spatu") 
            print("kembang spatu")
        elif teksturTepi == 3: 
            hasil.append("puring lele") 
            print("puring lele")
        elif teksturTepi == 0:
            if bentuk == 3: 
                hasil.append("Dafnah") 
            print("Dafnah")
        elif bentuk == 6: 
            hasil.append("klengkeng")
        else : 
            hasil.append("Tidak Diketahui")
    elif warna == 2:
        if Bau == 0: 
            hasil.append("Sirsak") 
            print("Sirsak")
        elif Bau == 1: 
            hasil.append("alpukat")
        else :
            hasil.append("Tidak Diketahui")
    elif warna == 4: 
        hasil.append("Wungu") 
        print("Wungu") 
    elif warna == 6: 
        hasil.append("Puring") 
        print("Puring") 
    else : 
        hasil.append("Tidak Diketahui")
            
def cariPred(tabeldaunPredi, daunPred):
    dataDaun = len(tabeldaunPredi) 
    
    for i in range(0,dataDaun):
        if(tabeldaunPredi[i] == daunPred):
            prediksi.append("True")
        else:
            prediksi.append("False")
            
def hitungPredi(tabelPredi):
    jmlBenar = 0
    jmlDataPredi = len(tabelPredi)
    
    for i in range(0,jmlDataPredi):
        if(tabelPredi[i] == "True"):
            jmlBenar=jmlBenar+1
            
    akurasi = (jmlBenar/ jmlDataPredi)*100
    
    return akurasi()

      
            
for i in range(0,jumDat):
    test1 = data['warna']
    test_warna = test1[i]
    
    test2 = data['Bentuk']
    test_bentuk = test2[i]
    
    test3 = data['Tekstur Tepi']
    test_teksTepi = test3[i]
    
    test4 = data['Bau']
    test_Bau = test4[i]
    
    klasifikasi(test_warna, test_bentuk,  test_teksTepi, test_Bau )
    
    
data["Hasil Akhir"] = hasil
cariPred(hasil, "sirsak")
data["prediksi"] = prediksi

akurasiPrediksi = hitungPredi(prediksi)
print("Hasil Perhitungan Akurasi Rule : ", akurasiPrediksi)          
            
            
