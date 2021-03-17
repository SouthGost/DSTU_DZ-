//  фывфывыфо вффыв!
//  ячсфв ы, воы фдв ясч
//  фыв фы лыв - фыд вф вячя
//  фыв фыв: "фвф ывфов фв"
//  флыво ырфвгр фгывршф. вр фывршфы рвш
//  фв тыфв жжжжжжж?

procedure delZnak(nameOfFile: string);
var
  znaki: set of char;
  out, inf: file;
  c: char;
begin
  znaki := ['!', ',', '.', '-', '?', '"', ';', ':'];
  Assign(out, './' + nameOfFile);
  Assign(inf, './time' + nameOfFile);
  Reset(out);
  Rewrite(inf); 
  while(not eof(out)) do
  begin
    read(out, c);
    if (not (c in znaki)) then
    begin
      write(inf, c);
    end;
  end;
  close(out);
  erase(out);
  close(inf);
  rename(inf, './' + nameOfFile);
end;

function valOfUnic(nameOfFile: string): integer;
var
  unicWord: set of string;
  out: text;
  i, j, n: integer;
  str: string;
  miniBuf: array of string;
  buf: array[0..512] of string;
begin
  unicWord := [];
  Assign(out, './' + nameOfFile);
  Reset(out);
  i := 0;
  while(not eof(out)) do
  begin
    readln(out, str);
    miniBuf := str.split(' ');
    for j := 0 to miniBuf.length - 1 do
    begin
      buf[i] := miniBuf[j];
      i += 1;
    end;
  end;
  n := 0;
  for j := 0 to i do
  begin
    if(not (buf[j] in unicWord)) then
    begin
      unicWord += [buf[j]];
      n += 1;
    end;
  end;
  close(out);
  valOfUnic := n;
end;

procedure massValWord(nameOfFile: string);
var
  unicWord: set of string;
  out: text;
  i, j, n, k: integer;
  str: string;
  miniBuf: array of string;
  buf: array[0..512] of string;
  valWord: array[0..512] of integer;
begin
  unicWord := [];
  Assign(out, './' + nameOfFile);
  Reset(out);
  i := 0;
  while(not eof(out)) do
  begin
    readln(out, str);
    miniBuf := str.split(' ');
    for j := 0 to miniBuf.length - 1 do
    begin
      buf[i] := miniBuf[j];
      i += 1;
    end;
  end;
  n := 0;
  for j := 0 to i do
  begin
    if(not (buf[j] in unicWord)) then
    begin
      unicWord += [buf[j]];
      valWord[j] := 1;
      n += 1;      
    end
    else
      begin
      valWord[j] := 0;
      for k := 0 to j - 1 do
        if(buf[j] = buf[k]) then
        begin
          valWord[k] += 1;
          break;
        end;  
    end;
  end;
  valWord[i + 1] := -1;
  for j := 0 to i do
  begin
    if valWord[j] <> 0 then
    begin
      writeln(buf[j], ' в тексте ', valWord[j], ' раз');
    end;
  end;
end;


begin
  delZnak('textZ.txt');
  writeln(valOfUnic('textZ.txt'));
  massValWord('textZ.txt');
  
  
  writeln('Конец'); 
end.