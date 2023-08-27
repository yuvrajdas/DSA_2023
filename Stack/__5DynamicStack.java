public class __5DynamicStack {

    public static class CustomStack{
        int data[];
        int top;
        
        public CustomStack(int cap){
            data = new int[cap];
            top = -1;
        }

        public void push(int val){
            if(top == data.length-1){
                int ndata[] = new int[data.length*2];
                for(int i=0; i<data.length; i++){
                    ndata[i] = data[i];
                }
                data = ndata;
            }
            top++;
            data[top] = val;
        }

        public void pop(){
            if(top == -1){
                System.out.println("Stack underflow");
                return;
            }
            int val = data[top];
            top--;
            System.out.println(val);
        }

        public void top(){
            if(top == -1){
                System.out.println("Stack underflow");
                return;
            }
            System.out.println(data[top]);
        }

        public void size(){
            System.out.println(top+1);
        }

        public void display(){
            for(int i=top; i>=0; i--){
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        CustomStack cs = new CustomStack(5);
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.push(5);
        cs.display();
        cs.push(10);
        cs.display();   
        cs.size();
        cs.pop();
        cs.display();
        cs.size();
    }
}
