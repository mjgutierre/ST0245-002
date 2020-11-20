public class Gini {

	public double weightedGini(float rightNode0, float rightNode1, float leftNode0, float leftNode1) {
		if((rightNode0+rightNode1)==0 || (leftNode0+leftNode1)==0)
		return 0.5;
		double result = ((leftNode0 + leftNode1) * impurity(leftNode0, leftNode1) + (rightNode0 + rightNode1) * impurity(rightNode0, rightNode1))
				/ (leftNode0 + leftNode1 + rightNode0 + rightNode1);
		return result;

	}

	public double impurity(float n0, float n1) {
		double p0 = n0 / (n1 + n0);
		double p1 = n1 / (n1 + n0);
		double total = 1.0 - (p0 * p0 + p1 * p1);
		return total;

	}

	public void main(String args[]) {
		System.out.println(impurity(1, 4));
		System.out.println(impurity(2, 1));
		System.out.println(weightedGini(4, 1, 1, 2));
	}
}