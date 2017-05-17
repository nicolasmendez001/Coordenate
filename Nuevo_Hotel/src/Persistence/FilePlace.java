package Persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import Model.Place;

public class FilePlace {
    private String fileName;
    private File file;
    private RandomAccessFile randomAccessFile;
    
    public FilePlace(String fileName){
        this.file=new File(fileName);
    }
    public void open(String mode){
        try {
            randomAccessFile = new RandomAccessFile(file, mode);
        } catch (FileNotFoundException ex) {
        }
    }
    public void close(){
        try {
            randomAccessFile.close();
        } catch (IOException ex) {
        }
    }

    public void save(Place place, int index){
        DAOPlace dAOPlace = new DAOPlace(place);

        try {
            randomAccessFile.seek(index*dAOPlace.RECORD_SIZE);
            randomAccessFile.writeInt(dAOPlace.getCode());
            randomAccessFile.writeByte(dAOPlace.getLevel());
            randomAccessFile.write(dAOPlace.getName()); // 
            randomAccessFile.write(dAOPlace.getAbreviate()); // array
            randomAccessFile.writeLong(dAOPlace.getCodeParent());
        } catch (IOException ex) {
          
        }
    }

    public Place load(int index){
        DAOPlace dAOPlace = new DAOPlace();
        try {
            randomAccessFile.seek(index*DAOPlace.RECORD_SIZE);
            dAOPlace.setCode(randomAccessFile.readInt());
            dAOPlace.setLevel(randomAccessFile.readByte());
            byte data[] = new byte[dAOPlace.NAME_LENGHT];
            randomAccessFile.read(data);
            dAOPlace.setName(data);
            data = new byte[dAOPlace.ABREVIATE_LENGHT];
            randomAccessFile.read(data);
            dAOPlace.setAbreviate(data);
            dAOPlace.setCodeParent(randomAccessFile.readLong());
        } catch (IOException ex) {
        }
        
     return dAOPlace.BintoPlace();  
   }
    
    /**
     * ordenar por el nombre alfabeticamente ascendente
     */
    
	public void sort() {
		this.open("rw");
		Place dataOne, dataTwo;
		boolean isSort = false;
		while (!isSort) {
			isSort = true;
			for (int i = 0; i < this.file.length() / DAOPlace.RECORD_SIZE - 1; i++) {
				dataOne = load(i);
				dataTwo = load(i + 1);
				if (dataOne.getName().compareTo(dataTwo.getName()) > 0) {
					this.save(dataTwo, i);
					this.save(dataOne, i + 1);
					isSort = false;
				}
			}
		}

		this.close();
	}
	
	public void sortShell() {
		this.open("rw");
		Place dataOne, dataTwo;
		 int gap = (int)this.file.length() / DAOPlace.RECORD_SIZE / 2;
		    while (gap > 0) {
		        for (int i = 0; i < this.file.length() / DAOPlace.RECORD_SIZE - gap; i++) {
		            int j = i + gap;
		            dataOne = load(j);
		            dataTwo = load(j-gap);
		            while (j >= gap && dataOne.getCode() > dataTwo.getCode()) {//tmp < array[j-gap] otro orden
		            	this.save(dataTwo, j);
		                j -= gap;
		            }
		            this.save(dataOne, j);
		        }
		        if (gap == 2) {
		            gap = 1;
		        }else{
		            gap /= 2.2;
		        }
		    }    
		this.close();
	}
	
	public void shell() {
		this.open("rw");
		int salto;
		Place dataOne, dataTwo;
		boolean flag;
		System.out.println(file.length());
		int size = (int) (this.file.length() / DAOPlace.RECORD_SIZE);
		for (salto = size / 2; salto != 0; salto /= 2) {
			System.out.println("salto: " + salto);
			flag = true;
			while (flag) {
				flag = false;
				for (int i = salto; i < this.file.length() / DAOPlace.RECORD_SIZE; i++) {
					dataOne = load(i-salto);
					dataTwo = load(i);
					if (dataOne.getCode() < dataTwo.getCode()) {
						this.save(dataOne, i);
						this.save(dataTwo, i-salto);
						flag = true;
					}
				}
			}
		}
		this.close();
	}
	
	public void searchCode(int code) {
	
	}
}
