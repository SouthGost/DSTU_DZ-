using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace _3._2.Net_Lab1
{
    /// <summary>
    /// Логика взаимодействия для MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private double function(double x)
        {
            return Math.Pow(Math.Cos(x),2);
        }

        private void addLine(int x1, int x2, int y1, int y2)
        {
            Line line = new Line();
            line.Stroke = System.Windows.Media.Brushes.Black;
            line.StrokeThickness = 2;
            line.X1 = x1;
            line.X2 = x2;
            line.Y1 = y1;
            line.Y2 = y2;
            pole.Children.Add(line);
        }

        private void drowFunction(double[] xs, double[] ys)
        {
            double minX = xs[0];
            double maxX = xs[xs.Length - 1];
            double minY = ys.Min(); //-5
            double maxY = ys.Max(); //+5
            label_x_min.Content = minX;
            label_x_max.Content = maxX;
            label_y_min.Content = minY;
            label_y_max.Content = maxY;
            int stepX = (int)(300 / (maxX - minX));
            int stepY = (int)(300 / (maxY - minY));
            int x1 = (int)((xs[0] - minX) * stepX);
            int y1 = (int)((maxY - ys[0]) * stepY);
            int x2;
            int y2;
            for(int i = 1; i< xs.Length; i++)
            {
                x2 = (int)((xs[i] - minX) * stepX);
                y2 = (int)((maxY - ys[i]) * stepY);
                addLine(x1, x2, y1, y2);
                x1 = x2;
                y1 = y2;
            }
        }

        private void countFunction(double a, double b, double c)
        {
            int lenfth = (int) Math.Ceiling((b - a) / c)+1;
            double[] xs = new double[lenfth];
            double[] ys = new double[lenfth];
            int i = 0;
            for(double x = a; x < b; x += c)
            {
                xs[i] = x;
                ys[i] = function(x);
                i++;
            }
            if (i < lenfth)
            {
                xs[i] = b;
                ys[i] = function(b);
            }
            drowFunction(xs, ys);
        }

        private void Button_click(object sender, EventArgs e)
        {
            try
            {
                double start;
                double end;
                double step;
                try
                {
                    start = Double.Parse(input_Start.Text);
                    end = Double.Parse(input_End.Text);
                    step = Double.Parse(input_Step.Text);
                    if(start >= end)
                    {
                        throw new Exception();
                    }
                } catch (Exception)
                {
                    throw new Exception("Не правильно введенные данные");
                }
                pole.Children.Clear();
                countFunction(start, end, step);

                label_message.Content = "ОК";
            } catch(Exception error)
            {
                label_message.Content = "Ошибка: " + error.Message;
            }

        }
    }
}
