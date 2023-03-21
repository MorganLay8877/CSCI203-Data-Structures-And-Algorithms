#include<iostream>
#include<vector>

using namespace std;

int partitionIndex(vector<int> &arr, int low, int high)
{
	int pivot = arr[high];
	int pIndex = low - 1;
	
	for(int i = low; i<high ; i++)
	{
		if(arr[i] <= pivot)
                {
                        pIndex++;
			swap(arr[i], arr[pIndex]);
			
		}
	}
	swap(arr[high], arr[pIndex + 1]);
	return pIndex;
}

void quickSort(vector<int> &male, int start, int end )
{
	if(start >= end)
	{
		return;
	}
	int paritionIndex = partitionIndex(male, start, end);
	quickSort(male, start, paritionIndex -1);
	quickSort(male, paritionIndex + 1, end);	
}
bool binarySearch(vector<int> &female, int age)
{
	int low = 0;
	int high = female.size() - 1;
	
	while(low<= high)
	{
		int mid = (low + high) / 2;
		
		if(age == female[mid])
		{
			return true;
		}
		else if ( age > female[mid])
		{
			low = (mid + 1);
		}
		else
		{
			high = (mid - 1);
		}
	}
	return false;
}

int main()
{
	int males, females;
	cout << "Enter data for both genders : ";
	cin >>males>>females;
        
	vector<int> male, female;
	cout << "Enter male : ";
	for ( int i = 0; i < males; i++)
	{
		int m;
		cin >> m;
		male.push_back(m);
	}
        
	cout << "Enter female : ";
	for ( int i = 0; i < females; i++)
	{
		int f;
		cin >> f;
		female.push_back(f);
	}
	
	quickSort(male, 0, males - 1);
	for(int female_age : female)
	{
		bool isPresent = binarySearch(male, female_age );
		
		if(isPresent)
		{
			cout<<"Output is : "<<female_age<<" ";
		}
	}
	
	
}
