class ErrorMessage	{

	public static void print(int position, String message)	{

		int i;

		System.out.println();

		for(i = 0; i < position; i++)	{

			System.out.println(" ");
		}

                System.out.println("^");
                System.out.println("****** Error: " + message + " *******");

		System.exit(0);
	}
}


