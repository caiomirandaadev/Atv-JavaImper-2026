public class SolucaoProva {


    public static boolean contem(int[] v, int tam, int elem) {
        for (int i = 0; i < tam; i++) {
            if (v[i] == elem) {
                return true; 
            }
        }
        return false;
    }

    // A
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;

        for (int i = 0; i < tamA; i++) {
            if (contem(u, tamU, a[i]) == false) {
                u[tamU] = a[i];
                tamU = tamU + 1;
            }
        }

        for (int i = 0; i < tamB; i++) {
            if (contem(u, tamU, b[i]) == false) {
                u[tamU] = b[i];
                tamU = tamU + 1;
            }
        }

        return tamU;
    }


    // B
    public static void ordenar(int[] v, int n) {
        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;

            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j = j - 1;
            }
            v[j + 1] = chave;
        }
    }



    //C 
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVSR = 0;

        for (int i = 0; i < tamV; i++) {
            if (contem(vsr, tamVSR, v[i]) == false) {
                vsr[tamVSR] = v[i];
                tamVSR = tamVSR + 1;
            }
        }

        return tamVSR;
    }


    //D
    public static void rotacionar(int[] v, int tam, int k) {
        if (tam <= 0) return;

    
        while (k < 0) {
            k = k + tam;
        }
        k = k % tam; 

        for (int r = 0; r < k; r++) {
            int primeiro = v[0];
            for (int i = 0; i < tam - 1; i++) {
                v[i] = v[i + 1];
            }
            v[tam - 1] = primeiro;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Teste Questão A ---");
        int[] a = {1, 2, 3, 5};
        int[] b = {3, 4, 5, 6};
        int[] u = new int[10];
        int tamU = uniao(a, 4, b, 4, u);
        System.out.print("União: ");
        for (int i = 0; i < tamU; i++) System.out.print(u[i] + " ");
        System.out.println();

        System.out.println("\n--- Teste Questão B ---");
        int[] vetOrd = {5, 2, 8, 1, 3};
        ordenar(vetOrd, 5);
        System.out.print("Ordenado(Insertion sort): ");
        for (int x : vetOrd) System.out.print(x + " ");
        System.out.println();

        System.out.println("\n--- Teste Questão C ---");
        int[] v = {5, 2, 5, 3, 3, 8, 3, 8, 2};
        int[] vsr = new int[9];
        int tamVSR = gerarVetorSemRepeticao(v, 9, vsr);
        System.out.print("Sem repetição: ");
        for (int i = 0; i < tamVSR; i++) System.out.print(vsr[i] + " ");
        System.out.println();

        System.out.println("\n-----Questão D-----");
        int[] vRot = {1, 2, 3, 4, 5};
        rotacionar(vRot, 5, 2);
        System.out.print("Rotacionado k=2: ");
        for (int x : vRot) System.out.print(x + " ");
        System.out.println();

        int[] vRot2 = {1, 2, 3, 4, 5};
        rotacionar(vRot2, 5, -1);
        System.out.print("Rotacionado k=-1: ");
        for (int x : vRot2) System.out.print(x + " ");
        System.out.println();
    }
}
