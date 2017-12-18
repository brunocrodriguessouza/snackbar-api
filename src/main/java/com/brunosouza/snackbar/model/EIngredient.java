package com.brunosouza.snackbar.model;

public enum EIngredient {
	
	LETTUCE {
		@Override
		public double getPrice() {
			return 0.40;
		}

		@Override
		public String getDescription() {
			return "lettuce";
		}
	},
	
	BACON {
		@Override
		public double getPrice() {
			return 2.00;
		}

		@Override
		public String getDescription() {
			return "bacon";
		}
	},
	
	BEEFBURGER {
		@Override
		public double getPrice() {
			return 3.00;
		}

		@Override
		public String getDescription() {
			return "beefburger";
		}
	},
	
	EGG {
		@Override
		public double getPrice() {
			return 0.80;
		}

		@Override
		public String getDescription() {
			return "egg";
		}
	},

	CHEESE {
		@Override
		public double getPrice() {
			return 1.50;
		}

		@Override
		public String getDescription() {
			return "cheese";
		}
	};


	public abstract double getPrice();
	public abstract String getDescription();

}
