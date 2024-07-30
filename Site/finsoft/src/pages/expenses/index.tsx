
import { useEffect, useState } from 'react';
import api from '@/services/api';
import Layout from '@/components/Layout';

interface Expense {
  id: number;
  description: string;
  totalAmount: number;
}

export default function Expenses() {
  const [expenses, setExpenses] = useState<Expense[]>([]);

  useEffect(() => {
    async function fetchExpenses() {
      const response = await api.get('/expenses');
      setExpenses(response.data);
    }
    fetchExpenses();
  }, []);

  return (
    <Layout>
      <h1>Expenses</h1>
      <ul>
        {expenses.map((expense) => (
          <li key={expense.id}>{expense.description} - {expense.totalAmount}</li>
        ))}
      </ul>
    </Layout>
  );
}
