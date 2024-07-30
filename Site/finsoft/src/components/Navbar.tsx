import Link from 'next/link';

export default function Navbar() {
  return (
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
  );
}
