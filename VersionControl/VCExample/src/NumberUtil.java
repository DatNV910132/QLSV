
public class NumberUtil {
	public boolean checkPerfectNumber (int num) {
		int temp = num ;
		for (int i = 1;i< num;i++) {
			if((num % i) == 0) 
				temp -= i;
		}
		if(temp == 0) return true;
		else return false;
	}
	
	/**
	 * @author TrongDuc
	 * @param num
	 * @return
	 */
	public boolean checkSquareNumber(int num){
		for(int i = 1; i <= num; i++){
			if (i * i == num)
				return true;
		}
		return false;
	}
	public boolean isPrimeNumber(int number){
        if((number == 1) || (number < 0)){
            return false;
        }
        int i;
        boolean flag = true;
        for(i = 2; i <= number/2; i++){
            if(number%i == 0){
                flag = false;
                break;
            }                
        }
        return flag;
    }
    
    public boolean isCompositeNumber(int number){
        if((number == 1) || (number < 0))
            return false;
        return !isPrimeNumber(number);
    }
}
