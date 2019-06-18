public String getWellNetForm(Node formula) {
		String result = "(";
		if(formula.data.equals("+")) result = result + getWellNetForm(formula.left)+"+"+getWellNetForm(formula.right)+")";
		else if(formula.data.equals("-")) result = result + getWellNetForm(formula.left)+"-"+getWellNetForm(formula.right)+")";
		else if(formula.data.equals("")) result = result + getWellNetForm(formula.left)+""+getWellNetForm(formula.right)+")";
		else if(formula.data.equals("/")) result = result + getWellNetForm(formula.left)+"/"+getWellNetForm(formula.right)+")";
		else result = formula.data;
		return result;
	}
	public double formulaCalculator(Node formula) {
		if(formula.data.equals("+")) return formulaCalculator(formula.left) + formulaCalculator(formula.right);
		else if(formula.data.equals("-")) return formulaCalculator(formula.left) - formulaCalculator(formula.right);
		else if(formula.data.equals("*")) return formulaCalculator(formula.left) * formulaCalculator(formula.right);
		else if(formula.data.equals("/")) return formulaCalculator(formula.left) / formulaCalculator(formula.right);
		return Double.parseDouble(formula.data);
	}