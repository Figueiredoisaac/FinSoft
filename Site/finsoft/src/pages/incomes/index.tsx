import { useEffect, useState } from 'react';
import api from '@/services/api';
import Layout from '@/components/Layout';

interface Income {
  id: number;
  description: string;
  amount: number;
}

export default function Incomes() {
  const [incomes, setIncomes] = useState<Income[]>([]);

  useEffect(() => {
    async function fetchIncomes() {
      const response = await api.get('/incomes');
      setIncomes(response.data);
    }
    fetchIncomes();
  }, []);

  return (
    <Layout>
      <h1>Incomes</h1>
      <ul>
        {incomes.map((income) => (
          <li key={income.id}>{income.description} - {income.amount}</li>
        ))}
      </ul>
    </Layout>
  );
}