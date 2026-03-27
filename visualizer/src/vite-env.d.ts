/// <reference types="vite/client" />

declare module "virtual:report-data" {
  const data: {
    tool: string;
    checker: string;
    report: unknown;
    metadata?: {
      checker_id?: string;
      checker_desc?: string;
    };
    sourcePath: string;
  }[];
  export default data;
}
