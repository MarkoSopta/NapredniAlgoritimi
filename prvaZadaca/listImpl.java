package prvaZadaca;

public class listImpl {
     private final int[] elements;
     private int size;
     private static final int CAPACITY = 8;

     public listImpl() {
          this.elements = new int[CAPACITY];
          this.size = 0;
     }

     public void dodaj(int element) {
          if (size == CAPACITY) {
               throw new IllegalStateException("Lista je puna");
          }

          elements[size++] = element;
     }


     public void pronadjiElement(int element){
          for (int index = 0; index < size; index++) {
               if (elements[index]==element){
                    System.out.println("Element "+element+" pronadjen na indeksu " + index);

               }
          }
     }
     public void dodajNaIndex(int element, int index) {
          if (index < 0 || index >= size || size == CAPACITY) {
               throw new IndexOutOfBoundsException("Neispravan indeks");
          }

          // Pomakni sve elemente desno od indeksa za jedno mjesto
          for (int i = size; i > index; i--) {
               elements[i] = elements[i - 1];
          }

          // Dodaj novi element na navedeni indeks
          elements[index] = element;
          size++;
     }

     public void obrisi(int index) {
          if (index < 0 || index >= size) {
               throw new IndexOutOfBoundsException("Neispravan indeks");
          }

          // Pomakni sve elemente lijevo od indeksa za jedno mjesto
          for (int i = index; i < size - 1; i++) {
               elements[i] = elements[i + 1];
          }

          // Postavi posljednji element na 0 i smanji veličinu liste
          elements[--size] = 0;
     }

     public int count() {
          // Vraća broj elemenata u listi
          return size;
     }

     public static void main(String[] args) {
          listImpl lista = new listImpl();
          lista.dodaj(1);
          lista.dodaj(2);
          lista.dodaj(3);
          lista.dodaj(4);
          lista.dodaj(5);
          lista.dodaj(6);
          lista.dodaj(7);
          lista.dodaj(8);

          System.out.println("Broj elemenata u listi: " + lista.count());

         // lista.obrisi(2);
         // lista.dodajNaIndex(3,7);
        //  lista.pronadjiElement(7);

          System.out.println("Broj elemenata u listi nakon brisanja: " + lista.count());
          System.out.println("Stanje liste nakon brisanja:");
          for (int i = 0; i < lista.count(); i++) {
               System.out.print(lista.elements[i] + " ");
          }
     }
}
