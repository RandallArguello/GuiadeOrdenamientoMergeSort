public class App {
    // Metodo MergeSort

    public static void mergeSort (int [] arr, int left, int rigth) {

        if (left < rigth){
            // Encuentra el punto medio del arreglo
            int mid = (left + rigth) / 2;
            // Ordena recursivamente la mitad izquierda
            mergeSort (arr, left, mid);
            // Ordena recursivamente la mitad derecha
            mergeSort(arr, mid + 1, rigth);
            // Combina las dos mitades ordenadas
            merge(arr, left, mid, rigth);
        }
     }
     // Metodo Merge
    private static void merge (int[] arr, int left, int mid, int rigth) {
        // Tamaño de los subarreglos a fusionar
        int SizeLeft = mid - left + 1;
        int SizeRigth = rigth - mid;

       //Arreglos temporales para almacenar los subarreglos
        int[] tempLeft = new int [SizeLeft];
        int[] tempRigth = new int [SizeRigth];

        // Copia datos a los arreglos temporales
        for (int i = 0; i < SizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < SizeRigth; j++) {
            tempRigth[j] = arr[mid + 1 + j];
        }
        // Fusiona los subarreglos temporales en el arreglo original
        int i = 0  ,  j= 0;
        int k = left; // Indice inicial para el arreglo fusionado

        
        while (i < SizeLeft && j < SizeRigth) {
            if (tempLeft[i] <= tempRigth[j])  {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRigth[j];
                j++;
            }
            k++;
        }
        // copia elementos restantes de tempLeft[] si los hay
        while (i < SizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }
        // Copia elementos restantes de tempRigth[] si los hay
        while (j < SizeRigth) {
            arr[k] = tempRigth[j];
            j++;
            k++;
        }

    }
    public static void main(String[] args) throws Exception {
       // Metodo Main
        int[] arr = {38,27,43,3,9,82,10};
        int n = arr.length;

        mergeSort(arr, 0, n - 1); //Llamada al metodo de ordenamiento MergeSort

        System.out.println("Arreglo ordenado:");
        for (int num: arr) {
            System.out.println(num + " ");
        }
        
    }
    
}
