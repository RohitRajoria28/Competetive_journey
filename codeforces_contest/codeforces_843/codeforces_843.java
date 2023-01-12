 // q1 

	public static void findCylpus(String st){
        int cut1=1;
        int cut2=2;
        int n=st.length();
        boolean flag=false;
        for(cut1=1;cut1<n-1;cut1++){
            for(cut2=cut1+1;cut2<n;cut2++){
                String s1=st.substring(0,cut1);
                String s2=st.substring(cut1,cut2);
                String s3=st.substring(cut2,n);

                if(s2.compareTo(s1)>=0 && s2.compareTo(s3)>=0){
                    flag=true;
                    System.out.println(  s1+" "+s2+" "+s3);
                    return ;
                }
                 if(s2.compareTo(s1)<=0 && s2.compareTo(s3)<=0){
                    flag=true;
                    System.out.println( s1+" "+s2+" "+s3);
                   return;
                }
            }
        }
    } 