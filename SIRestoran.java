import java.util.Scanner;

//class Pembeli
class Pembeli{
    String namaPembeli, noHp;
    Pembeli(String nama, String noHp){
        this.namaPembeli = nama;
        this.noHp = noHp;
    }
}

//class Pesanan
class Pesanan{
    int kodePesanan, harga;
    String namaPesanan;
    Pesanan(int kode, String nama, int harga){
        this.kodePesanan = kode;
        this.namaPesanan = nama;
        this.harga = harga;
    }
}

//class Double Linked Lists
class DoubleLinkedLists{
    Node_17 head;
    int size;

    DoubleLinkedLists(){
        head=null;
        size=0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addFirst(Pembeli pb, Pesanan ps){
        if (isEmpty()) {
            head = new Node_17(null, pm, ps, null);
        } else {
            Node_17 newNode = new Node_17(null, pm, ps, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Pembeli pm, Pesanan ps){
        if (isEmpty()) {
            addFirst(pm, ps);
        } else {
            Node_17 current = head;
            while(current.next != null){
                current = current.next;
            }
            Node_17 newNode = new Node_17(current, pm, ps, null);
            current.next = newNode;
            size++;
        }
    }

    public void print(){
        if (!isEmpty()){
            Node_17 tmp = head;
            while(tmp != null){
				System.out.println(tmp.data+"\t");
                tmp = tmp.next;
            }
            System.out.println("\Berhasil dicetak");
        }else{
			System.out.println("Linked Lists masih kosong");
        }
    }

    public void removeFirst() throws Exception{
       if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus");
        } else if (size == 1) {
            removeLast();
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
	
	public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
        Node_15 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Nomor Antrian : " + current.order.kodePesanan);
        System.out.println("Nama Customer : " + current.order.namaPesanan);
        System.out.println("Nama Customer : " + current.order.harga);
        current.next = null;
        size--;
    }
	
	public void hitungPendapatan(){
        int total = 0;
        Node_15 current = head;
        while (current != null){
            total = total + current.order.harga;
            current = current.next;
        }
        System.out.println("\nTotal Pendapatan = " + total);
    }
}

class Node_17{
    Pembeli pembeli;
    Pesanan pesanan;
    Node_17 prev, next;
    Node_17(Node_17 prev, Pembeli pembeli, Pesanan pesanan, Node_17 next){
        this.prev = prev;
        this.pembeli = pembeli;
        this.pesanan = pesanan;
        this.next = next;
    }
}

public static void Pilihmenu(){
        System.out.println("\nPilih Menu:");
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian");
        System.out.println("4. Laporan Pengurutan by Nama");
        System.out.println("5. Hitung total pendapatan");
        System.out.println("6. Keluar");
        System.out.println("-------------------");
    }

public class SIRestoran{
	public static void main(String[] args){
		System.out.println("====== QUIZ 2 PRAKTIKUM ASD TI-1G dan TI-1F ======");
		System.out.println("dibuat oleh : Maria Fadilla");
		System.out.println("NIM : 2141720063");
		System.out.println("Absen : 17");
		Pilihmenu();
		Scanner in = new Scanner(System.in);
	}
}
