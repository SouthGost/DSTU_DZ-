package Lab5;

public class Lab {

    public static int MyRandom(int min, int max) throws Exception {
        if(min == max){
            return min;
        }
        if(min > max){
            throw new Exception("не правильные параметры");
        }
        return (int)Math.round(Math.random()*(max-min))+min;
    }

    public static void MyShowArr(int[] arr){
        for(var elem: arr){
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        GenetikAlg alg = new GenetikAlg(8,3,10,20,3,3, 1,250);
        alg.start();
    }
}

class GenetikAlg{
    private int[] valueArr;
    private Generation[] lastGeneration;
    private Generation[] newGeneration;
    private int m;
    private int n;
    private int z;
    private int k;
    private int k_ = 0;
    private double probability;
    private int maxParam;

    public static int[] RandomArr(int length, int min, int max) throws Exception {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++){
            arr[i] = Lab.MyRandom(min, max);
        }

        return arr;
    }

    public GenetikAlg(int m, int n, int t1, int t2, int z, int k, double probability, int maxParam) throws Exception {
        this.m = m;
        this.n = n;
        this.z = z;
        this.k = k;
        this.probability = probability;
        this.maxParam = maxParam;
        valueArr = RandomArr(m,t1,t2);
        lastGeneration = new Generation[z];
        newGeneration = new Generation[z];

        for(int i = 0; i < lastGeneration.length; i++){
            lastGeneration[i] = new Generation(valueArr, RandomArr(m, 0, maxParam), n, maxParam);
        }
    }

    public void start() throws Exception {
        while(k_ < k){
            choosePair();
            if(getbest(lastGeneration) == getbest(newGeneration)){
                k_++;
            }else{
                k_ = 0;
            }
            lastGeneration = newGeneration;
        }
        System.out.println();
        System.out.println("лучшее поколение");
        for(int i = 0; i < newGeneration.length; i++){
            Lab.MyShowArr(newGeneration[i].getParameters());
            System.out.println(newGeneration[i].getMaxWorkload());
        }
    }

    public int getbest(Generation[] arr){
        int minI = 0;

        for(int i = 1; i < arr.length; i++){
            if(arr[i].getMaxWorkload() < arr[minI].getMaxWorkload()){
                minI = i;
            }
        }

        return arr[minI].getMaxWorkload();
    }

    public void choosePair() throws Exception {
        System.out.println();
        System.out.println("Начальное поколение");
        for(int i = 0; i < lastGeneration.length; i++){
            Lab.MyShowArr(lastGeneration[i].getParameters());
            System.out.println(lastGeneration[i].getMaxWorkload());
        }

        int z_ = z;

        for(int i = 0; i < z; i++){
            for(int j = i+1; j < z; j++){
                double left = (z-j+(z-i-1)*(z-i-2)*1.0/2);

                if(z_ > 0 && Math.random() < (z_)/left){
                    System.out.println();
                    System.out.println("Пара " + i + " " + j);
                    newGeneration[z-z_] = comparator(i,j);
                    z_--;
                }
            }
        }
    }

    public void mutator(int[] arr) throws Exception {
        int pos = Lab.MyRandom(0,arr.length-1);
        int bit = Lab.MyRandom(0,7);

        System.out.print("Бит " + bit + " ");
        System.out.print(arr[pos] + " ");
        if((arr[pos]/(int)Math.pow(2,bit)) % 2  == 1){
            arr[pos]-=(int)Math.pow(2,bit);
        }else{
            arr[pos]+=(int)Math.pow(2,bit);
        }
        System.out.print(arr[pos]);
        System.out.println();
    }

    public Generation comparator(int parentId1, int parentId2) throws Exception {
        if(parentId1 == parentId2 || parentId1 >= z || parentId2 >= z){
            throw new Exception("не правильные параметры");
        }
        int[] parent1 = lastGeneration[parentId1].getParameters();
        int[] parent2 = lastGeneration[parentId2].getParameters();
        int border = Lab.MyRandom(1, m-1);
        int[] child1 = new int[m];
        int[] child2 = new int[m];

        System.out.println("Барьер " + border);
        for(int i = 0; i < border ; i++){
            child1[i] = parent1[i];
            child2[i] = parent2[i];
        }
        for(int i = border; i < m ; i++){
            child1[i] = parent2[i];
            child2[i] = parent1[i];
        }
        System.out.println("До мутации");
        Lab.MyShowArr(child1);
        Lab.MyShowArr(child2);
        mutator(child1);
        mutator(child2);
        System.out.println("После мутации");
        Lab.MyShowArr(child1);
        Lab.MyShowArr(child2);
        Generation gСhild1 = new Generation(valueArr, child1, n, maxParam);
        Generation gСhild2 = new Generation(valueArr, child2, n, maxParam);
        System.out.println("Загруженность");
        System.out.println(lastGeneration[parentId1].getMaxWorkload());
        System.out.println(lastGeneration[parentId2].getMaxWorkload());
        System.out.println(gСhild1.getMaxWorkload());
        System.out.println(gСhild2.getMaxWorkload());
        if(gСhild2.getMaxWorkload() <= gСhild1.getMaxWorkload() && gСhild2.getMaxWorkload() <= lastGeneration[parentId2].getMaxWorkload() && gСhild2.getMaxWorkload() <= lastGeneration[parentId1].getMaxWorkload()){
            System.out.println("Берем ребенка21");
            return gСhild2;
        }else if(gСhild1.getMaxWorkload() <= gСhild2.getMaxWorkload() && gСhild1.getMaxWorkload() <= lastGeneration[parentId2].getMaxWorkload() && gСhild1.getMaxWorkload() <= lastGeneration[parentId1].getMaxWorkload()){
            System.out.println("Берем ребенка12");
            return gСhild1;
        }else if(lastGeneration[parentId2].getMaxWorkload() <= gСhild2.getMaxWorkload() && lastGeneration[parentId2].getMaxWorkload() <= gСhild1.getMaxWorkload() && lastGeneration[parentId2].getMaxWorkload() <= lastGeneration[parentId1].getMaxWorkload()){
            System.out.println("Берем родителя2");
            return lastGeneration[parentId2];
        }else{
            System.out.println("Берем родителя1");
            return lastGeneration[parentId1];
        }
    }


}

class Generation{
    private int[] parameters;
    private int[] workload;
    private int maxWorkload;

    public Generation(int[] valueArr, int[] parameters, int n, int maxParam){
        this.parameters = new int[valueArr.length];
        workload = new int[n];

        for(int i = 0; i < n; i++){
            workload[i] = 0;
        }
        for(int i = 0; i < parameters.length; i++){
            this.parameters[i] = parameters[i];

            for(int j = 1; j <= n; j++){
                if(this.parameters[i]<maxParam*j*1.0/n){
                    workload[j-1] += valueArr[i];
                    break;
                }
            }
        }
        int maxI = 0;

        for(int i = 1; i < workload.length; i++){
            if(workload[i] > workload[maxI]){
                maxI = i;
            }
        }
        maxWorkload = workload[maxI];
    }

    public int[] getParameters(){
        int[] sendedArr = new int[parameters.length];

        for(int i = 0; i < parameters.length; i++){
            sendedArr[i] = parameters[i];
        }

        return sendedArr;
    }

    public int getMaxWorkload(){

        return maxWorkload;
    }


}
