import { Routes, Route, NavLink } from "react-router-dom";
import { IndexPage } from "@/routes/IndexPage";
import { TestShowPage } from "@/routes/TestShowPage";
import { ConfirmPage } from "@/routes/ConfirmPage";

const navLinkClass = ({ isActive }: { isActive: boolean }) =>
  isActive
    ? "px-3 py-1.5 rounded-lg bg-ink text-white text-sm font-medium"
    : "px-3 py-1.5 rounded-lg text-muted hover:text-ink hover:bg-ink/[0.04] text-sm font-medium transition-colors";

export default function App() {
  return (
    <div className="min-h-screen gradient-bg">
      <header className="sticky top-0 z-50 border-b border-ink/[0.06] bg-white/80 backdrop-blur-md">
        <div className="mx-auto flex w-full max-w-[90rem] items-center justify-between gap-4 px-6 py-4">
          <div className="flex items-center gap-3">
            <div className="flex h-9 w-9 items-center justify-center rounded-lg bg-gradient-to-br from-accent to-violet text-white text-sm font-bold">
              S
            </div>
            <div>
              <h1 className="text-base font-semibold text-ink leading-tight">
                ScenSCT Visualizer
              </h1>
              <p className="text-xs text-muted">
                Test Signal Explorer for Any Checker
              </p>
            </div>
          </div>
          <nav className="flex items-center gap-1">
            <NavLink to="/" className={navLinkClass}>
              Dashboard
            </NavLink>
            <NavLink to="/confirm" className={navLinkClass}>
              Annotate
            </NavLink>
          </nav>
        </div>
      </header>

      <main className="mx-auto w-full max-w-[90rem] px-6 py-6">
        <Routes>
          <Route path="/" element={<IndexPage />} />
          <Route path="/checker/:tool/:checker?" element={<TestShowPage />} />
          <Route path="/confirm" element={<ConfirmPage />} />
          <Route path="/confirm/:tool/:checker" element={<ConfirmPage />} />
        </Routes>
      </main>
    </div>
  );
}
