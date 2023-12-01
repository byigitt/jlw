// ***************************************************************
// FILE: EmployeeList.java
//
// Purpose: Defines a class that represents a list of employees
//
// ***************************************************************
public class EmployeeList
{
	private EmployeeNode front; //first node in list
	//-----------------------------------------
	// Constructor. Initially list is empty.
	//-----------------------------------------
	public EmployeeList()
	{
		front = null;
	}

	//-----------------------------------------
	// Adds given employee to end of list.
	//-----------------------------------------
	public void addToEnd(Employee e)
	{
		EmployeeNode newNode = new EmployeeNode(e);

		if (front == null) {
			front = newNode;
		} else {
			EmployeeNode current = front;
			while (current.next != null) {
				current = current.next;
			}

			current.next = newNode;
		}
	}
	//-------------------------------------------------------------------
	// Checks whether the employee with name n is present in linked list
	//-------------------------------------------------------------------
	public boolean search(String n) 
	{
        EmployeeNode current = front;
        
        while (current != null) {
            if (current.val.toString().equals(n)) {
                return true;
            }
            
            current = current.next;
        }
        
        return false;
	}
	//------------------------------------------------
	// Prints the list elements from first to last.
	//------------------------------------------------
	public void print()
	{
        System.out.println("--------------------");
        System.out.print("List elements: ");
        
        EmployeeNode current = front;
        
        while (current != null) {
            System.out.print(current.val.toString() + " ");
            current = current.next;
        }
        
        System.out.println("\n-----------------------\n");
	}
	//*************************************************************
	// An inner class that represents a node in the employee list.
	// The public variables are accessed by the EmployeeList class.
	//*************************************************************
	private class EmployeeNode
	{
		public Employee val; //Employee object in the node
		public EmployeeNode next; //link to next node in list
		//----------------------------------
		// Constructor; sets up the node
		//----------------------------------
		public EmployeeNode(Employee e)
		{
			this.val = e;
			this.next = null;
		}
	}
}