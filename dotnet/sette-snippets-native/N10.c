int __declspec(dllexport) NativeFunction_fun(int x)
{
	if (x == 20160101)
	{
		return 1;
	}
	else
	{
		return 0;
	}
}

void __declspec(dllexport) NativeObject_calculate(int* x, int a)
{
	if (a == 4064256)  // 2016*2016
	{
		*x = 2016;
	}
	else
	{
		*x = 0;
	}
}