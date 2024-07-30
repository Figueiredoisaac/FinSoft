// src/pages/index.tsx
import React from 'react';
import Link from 'next/link';

const Home: React.FC = () => {
  return (
    <div>
      <h1>Welcome to FinSoft</h1>
      <nav>
        <ul>
          <li>
            <Link href="/dashboard">Dashboard</Link>
          </li>
          <li>
            <Link href="/incomes">Incomes</Link>
          </li>
          <li>
            <Link href="/expenses">Expenses</Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

export default Home;
