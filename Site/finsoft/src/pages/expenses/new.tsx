// expenses/new.tsx
import { useState } from 'react';
import api from '@/services/api';
import { useRouter } from 'next/router';
import Layout from '@/components/Layout';

export default function NewExpense() {
  const [description, setDescription] = useState('');
  const [totalAmount, setTotalAmount] = useState('');
  const [paymentDate, setPaymentDate] = useState('');
  const [fixed, setFixed] = useState(false);
  const [paymentType, setPaymentType] = useState('');
  const router = useRouter();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await api.post('/expenses', { description, totalAmount, paymentDate, fixed, paymentType });
      router.push('/expenses');
    } catch (error) {
      console.error('Failed to save expense:', error);
    }
  };

  return (
    <Layout>
      <h1>New Expense</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          placeholder="Description"
          required
        />
        <input
          type="number"
          value={totalAmount}
          onChange={(e) => setTotalAmount(e.target.value)}
          placeholder="Total Amount"
          required
        />
        <input
          type="date"
          value={paymentDate}
          onChange={(e) => setPaymentDate(e.target.value)}
          required
        />
        <label>
          Fixed
          <input
            type="checkbox"
            checked={fixed}
            onChange={(e) => setFixed(e.target.checked)}
          />
        </label>
        <input
          type="text"
          value={paymentType}
          onChange={(e) => setPaymentType(e.target.value)}
          placeholder="Payment Type"
          required
        />
        <button type="submit">Save</button>
      </form>
    </Layout>
  );
}
