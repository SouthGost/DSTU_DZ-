var
  out: text;
  i, n: integer;
  str: String;


begin
  Assign(out, './text.txt');
  
  while true do
  begin
    str:='';
    Reset(out);
  
    i := 1;
    writeln('введите номер строки');
    read(n);
    
      while(n <> i - 1) do
      begin
        readln(out, str);
        i += 1;
      end;
      if (str<>'') then
      writeln(str)
      else
      writeln('такой строки нет');
    
  end;
  
  writeln('Конец');
  Close(out);
  
  
end.