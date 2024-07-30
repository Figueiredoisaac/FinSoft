// incomes/new.tsx
import { useState } from 'react';
import api from '@/services/api';
import { useRouter } from 'next/router';
import Layout from '@/components/Layout';

export default function NewIncome() {
  const [description, setDescription] = useState('');
  const [amount, setAmount] = useState('');
  const [receiptDate, setReceiptDate] = useState('');
  const [fixed, setFixed] = useState(false);
  const [paymentType, setPaymentType] = useState('');
  const router = useRouter();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await api.post('/incomes', { description, amount, receiptDate, fixed, paymentType });
      router.push('/incomes');
    } catch (error) {
      console.error('Failed to save income:', error);
    }
  };

  return (
    <Layout>
      <h1>New Income</h1>
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
          value={amount}
          onChange={(e) => setAmount(e.target.value)}
          placeholder="Amount"
          required
        />
        <input
          type="date"
          value={receiptDate}
          onChange={(e) => setReceiptDate(e.target.value)}
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
